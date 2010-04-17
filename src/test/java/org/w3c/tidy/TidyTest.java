package org.w3c.tidy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import junit.framework.TestCase;

public class TidyTest extends TestCase {
	private static final String[] EXT = {"html", "xml", "xhtml"};

	private final String t;
	private final int r;
	private final String base;
	
    public TidyTest(final String base, final String t, final int r) {
        super(t);
        this.t = t;
        this.r = r;
        this.base = base;
    }
    
    private static void write(final ByteArrayOutputStream os, final String path) throws IOException {
    	final OutputStream o = new FileOutputStream(path);
    	o.write(os.toByteArray());
    	o.flush();
    	o.close();
    }
    
    public void runTest() {
    	final Tidy tidy = new Tidy();
    	final String cfg = base + "input/cfg_" + t + ".txt";
    	tidy.setConfigurationFromFile(new File(cfg).exists() ? cfg : base + "input/cfg_default.txt" );
    	tidy.setTidyMark(false);
    	tidy.setTidyCompat(true);
    	String fname = null;
    	File f = null;
    	for (String s : EXT) {
    		fname = "./input/in_" + t + '.' + s;
    		f = new File(base, fname);
    		if (f.exists()) {
    			break;
    		}
    	}
    	final InputStream is;
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			throw new RuntimeException("can't find input file");
		}
    	final ByteArrayOutputStream os = new ByteArrayOutputStream();
    	final ByteArrayOutputStream es = new ByteArrayOutputStream();
    	tidy.setErrout(new PrintWriter(es));
    	tidy.setInputStreamName(fname);
    	tidy.parse(is, os);
    	int x = tidy.getParseErrors() > 0 ? 2 : tidy.getParseWarnings() > 0 ? 1 : 0;
    	try {
    		write(os, base + "tmp/out_" + t + ".html");
    		write(es, base + "tmp/msg_" + t + ".txt");
    		InputStream os2 = null;
    		try {
    			os2 = new BufferedInputStream(new FileInputStream(base + "output/out_" + t + ".html"));
    		} catch (IOException e) {
    			os2 = new ByteArrayInputStream(new byte[0]);
    		}
			diff("outputs", new ByteArrayInputStream(os.toByteArray()), os2);
			diff("messages", new ByteArrayInputStream(es.toByteArray()),
					new BufferedInputStream(new FileInputStream(base + "output/msg_" + t + ".txt")));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		assertEquals(r, x);
    }

    private static void diff(final String what, final InputStream s1, final InputStream s2) throws IOException {
    	s1.mark(100000);
    	s2.mark(100000);
    	for (int x = 1; ; ++x) {
    		int b1 = s1.read();
    		int b2 = s2.read();
    		if (b1 != b2) {
    			if (b1 == -1 && b2 == 'T') {
    				final byte[] b = new byte[19];
    				s2.read(b);
    				final String s = new String(b);
    				if (s.equals("o learn more about ")) {
    					break;
    				}
    			}
    			s1.reset();
    			s2.reset();
    			final BufferedReader br1 = new BufferedReader(new InputStreamReader(s1));
    			final BufferedReader br2 = new BufferedReader(new InputStreamReader(s2));
    			String l1 = "";
    			String l2 = "";
    			while (true) {
    				l1 = br1.readLine();
    				l2 = br2.readLine();
    				if (l1 == null && l2 != null || !l1.equals(l2)) {
    					break;
    				}
    			}
    			br1.close();
    			br2.close();
    			fail(what + " differ at byte " + x + ":\nExpect: " + l2 + "\nActual: " + l1);
    		}
    		if (b1 == -1) {
    			break;
    		}
    	}
    	s1.close();
    	s2.close();
    }
}
