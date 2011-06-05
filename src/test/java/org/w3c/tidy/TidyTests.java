package org.w3c.tidy;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import junit.framework.Test;
import junit.framework.TestSuite;

public final class TidyTests {
    public static Test suite() {
        final TestSuite suite = new TestSuite("Tidy tests");
        final URL tests = TidyTests.class.getClassLoader().getResource("tidytests/testcases.txt");
        final Scanner sc;
        try {
			sc = new Scanner(tests.openStream());
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
        final String base = new File(tests.getFile()).getParent() + '/';
        new File(base + "tmp").mkdir();
        while (sc.hasNext()) {
        	final String t = sc.next();
        	final int r = sc.nextInt();
        	suite.addTest(new TidyTester(base, t, r));
        }
        return suite;
    }
}