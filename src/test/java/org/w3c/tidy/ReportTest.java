/*
 *  Java HTML Tidy - JTidy
 *  HTML parser and pretty printer
 *
 *  Copyright (c) 1998-2000 World Wide Web Consortium (Massachusetts
 *  Institute of Technology, Institut National de Recherche en
 *  Informatique et en Automatique, Keio University). All Rights
 *  Reserved.
 *
 *  Contributing Author(s):
 *
 *     Dave Raggett <dsr@w3.org>
 *     Andy Quick <ac.quick@sympatico.ca> (translation to Java)
 *     Gary L Peskin <garyp@firstech.com> (Java development)
 *     Sami Lempinen <sami@lempinen.net> (release management)
 *     Fabrizio Giustina <fgiust at users.sourceforge.net>
 *
 *  The contributing author(s) would like to thank all those who
 *  helped with testing, bug fixes, and patience.  This wouldn't
 *  have been possible without all of you.
 *
 *  COPYRIGHT NOTICE:
 *
 *  This software and documentation is provided "as is," and
 *  the copyright holders and contributing author(s) make no
 *  representations or warranties, express or implied, including
 *  but not limited to, warranties of merchantability or fitness
 *  for any particular purpose or that the use of the software or
 *  documentation will not infringe any third party patents,
 *  copyrights, trademarks or other rights.
 *
 *  The copyright holders and contributing author(s) will not be
 *  liable for any direct, indirect, special or consequential damages
 *  arising out of any use of the software or documentation, even if
 *  advised of the possibility of such damage.
 *
 *  Permission is hereby granted to use, copy, modify, and distribute
 *  this source code, or portions hereof, documentation and executables,
 *  for any purpose, without fee, subject to the following restrictions:
 *
 *  1. The origin of this source code must not be misrepresented.
 *  2. Altered versions must be plainly marked as such and must
 *     not be misrepresented as being the original source.
 *  3. This Copyright notice may not be removed or altered from any
 *     source or altered source distribution.
 *
 *  The copyright holders and contributing author(s) specifically
 *  permit, without fee, and encourage the use of this source code
 *  as a component for supporting the Hypertext Markup Language in
 *  commercial products. If you use this source code in a product,
 *  acknowledgment is not required but would be appreciated.
 *
 */
package org.w3c.tidy;

import junit.framework.TestCase;


/**
 * Test for Report messages. <strong>This test case actually requires EN locale to run successfully. </strong>.
 * @author fgiust
 * @version $Revision$ ($Author$)
 */
public class ReportTest extends TestCase
{

    /**
     * report instance.
     */
    private Report report;

    /**
     * lexer instance.
     */
    private Lexer lexer;

    /**
     * instantiates a new test.
     * @param name test name
     */
    public ReportTest(final String name)
    {
        super(name);
    }

    /**
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        this.report = new Report();
        this.lexer = new Lexer(null, new Configuration(report), this.report);
        lexer.lines = 12;
        lexer.columns = 34;
    }

    /**
     * test getMessage with the <code>missing_endtag_for</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageMissingEndtagFor() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "missing_endtag_for",
            new Object[]{"test"});
        assertEquals("line 12 column 34 - Warning: missing </test>", message);
    }

    /**
     * test getMessage with the <code>missing_endtag_before</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageMissingEndtagBefore() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "missing_endtag_before",
            new Object[]{"test", "bee"});
        assertEquals("line 12 column 34 - Warning: missing </test> before bee", message);
    }

    /**
     * test getMessage with the <code>discarding_unexpected</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageDiscardingUnexpected() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "discarding_unexpected",
            new Object[]{"test"});
        assertEquals("line 12 column 34 - Warning: discarding unexpected test", message);
    }

    /**
     * test getMessage with the <code>nested_emphasis</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageNestedEmphasis() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.INFO,
            "nested_emphasis",
            new Object[]{"test"});
        assertEquals("line 12 column 34 - Info: nested emphasis test", message);
    }

    /**
     * test getMessage with the <code>coerce_to_endtag</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageCoerceToEndtag() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.INFO,
            "coerce_to_endtag",
            new Object[]{"test"});
        assertEquals("line 12 column 34 - Info: <test> is probably intended as </test>", message);
    }

    /**
     * test getMessage with the <code>non_matching_endtag</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageNonMatchingEndtag() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "non_matching_endtag",
            new Object[]{"<test>", "bee"});
        assertEquals("line 12 column 34 - Warning: replacing unexpected <test> by </bee>", message);
    }

    /**
     * test getMessage with the <code>tag_not_allowed_in</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageTagNonAllowedIn() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "tag_not_allowed_in",
            new Object[]{"<test>", "bee"});
        assertEquals("line 12 column 34 - Warning: <test> isn't allowed in <bee> elements", message);
    }

    /**
     * test getMessage with the <code>doctype_after_tags</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageDoctypeAfterTags() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "doctype_after_tags", (Object[])null);
        assertEquals("line 12 column 34 - Warning: <!DOCTYPE> isn't allowed after elements", message);
    }

    /**
     * test getMessage with the <code>missing_starttag</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageMissingStarttag() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "missing_starttag",
            new Object[]{"test"});
        assertEquals("line 12 column 34 - Warning: missing <test>", message);
    }

    /**
     * test getMessage with the <code>using_br_inplace_of</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageUsingBrInPlaceOf() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "using_br_inplace_of",
            new Object[]{"test"});
        assertEquals("line 12 column 34 - Warning: using <br> in place of test", message);
    }

    /**
     * test getMessage with the <code>inserting_tag</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageInsertingTag() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "inserting_tag",
            new Object[]{"test"});
        assertEquals("line 12 column 34 - Warning: inserting implicit <test>", message);
    }

    /**
     * test getMessage with the <code>cant_be_nested</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageCantBeNested() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "cant_be_nested",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Warning: <test> can't be nested", message);
    }

    /**
     * test getMessage with the <code>proprietary_element</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageProprietaryElement() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "proprietary_element",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Warning: <test> is not approved by W3C", message);
    }

    /**
     * test getMessage with the <code>obsolete_element</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageObsoleteElement() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "obsolete_element",
            new Object[]{"<test>", "<bee>"});
        assertEquals("line 12 column 34 - Warning: replacing obsolete element <test> by <bee>", message);
    }

    /**
     * test getMessage with the <code>replacing_element</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageReplacingElement() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "replacing_element",
            new Object[]{"<test>", "<bee>"});
        assertEquals("line 12 column 34 - Warning: replacing <test> by <bee>", message);
    }

    /**
     * test getMessage with the <code>trim_empty_element</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageTrimEmptyElement() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "trim_empty_element",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Warning: trimming empty <test>", message);
    }

    /**
     * test getMessage with the <code>missing_title_element</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageMissingTitleElement() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "missing_title_element", (Object[])null);
        assertEquals("line 12 column 34 - Warning: inserting missing 'title' element", message);
    }

    /**
     * test getMessage with the <code>illegal_nesting</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageIllegalNesting() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "illegal_nesting",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Warning: <test> shouldn't be nested", message);
    }

    /**
     * test getMessage with the <code>noframes_content</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageNoframesContent() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "noframes_content",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Warning: <test> not inside 'noframes' element", message);
    }

    /**
     * test getMessage with the <code>inconsistent_version</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageInconsistentVersion() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "inconsistent_version", (Object[])null);
        assertEquals("line 12 column 34 - Warning: html doctype doesn't match content", message);
    }

    /**
     * test getMessage with the <code>malformed_doctype</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageMalformedDoctype() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "malformed_doctype", (Object[])null);
        assertEquals("line 12 column 34 - Warning: expected \"html PUBLIC\" or \"html SYSTEM\"", message);
    }

    /**
     * test getMessage with the <code>content_after_body</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageContentAfterBody() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "content_after_body", (Object[])null);
        assertEquals("line 12 column 34 - Warning: content occurs after end of body", message);
    }

    /**
     * test getMessage with the <code>malformed_comment</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageMalformedComment() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "malformed_comment", (Object[])null);
        assertEquals("line 12 column 34 - Warning: adjacent hyphens within comment", message);
    }

    /**
     * test getMessage with the <code>bad_comment_chars</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageBadCommentChars() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "bad_comment_chars", (Object[])null);
        assertEquals("line 12 column 34 - Warning: expecting -- or >", message);
    }

    /**
     * test getMessage with the <code>bad_xml_comment</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageBadXmlComment() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "bad_xml_comment", (Object[])null);
        assertEquals("line 12 column 34 - Warning: XML comments can't contain --", message);
    }

    /**
     * test getMessage with the <code>bad_cdata_content</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageBadCdataComment() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "bad_cdata_content", (Object[])null);
        assertEquals("line 12 column 34 - Warning: '<' + '/' + letter not allowed here", message);
    }

    /**
     * test getMessage with the <code>inconsistent_namespace</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageInconsistentNamespace() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "inconsistent_namespace", (Object[])null);
        assertEquals("line 12 column 34 - Warning: html namespace doesn't match content", message);
    }

    /**
     * test getMessage with the <code>dtype_not_upper_case</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageDtypeNotUpperCase() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "dtype_not_upper_case", (Object[])null);
        assertEquals("line 12 column 34 - Warning: SYSTEM, PUBLIC, W3C, DTD, EN must be upper case", message);
    }

    /**
     * test getMessage with the <code>unexpected_end_of_file</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageUnexpectedEndOfFile() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "unexpected_end_of_file",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Warning: <test> end of file while parsing attributes", message);
    }

    /**
     * test getMessage with the <code>suspected_missing_quote</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageSuspectedMissingQuote() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.ERROR, "suspected_missing_quote", (Object[])null);
        assertEquals("line 12 column 34 - Error: missing quotemark for attribute value", message);
    }

    /**
     * test getMessage with the <code>duplicate_frameset</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageDuplicateFrameset() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.ERROR, "duplicate_frameset", (Object[])null);
        assertEquals("line 12 column 34 - Error: repeated FRAMESET element", message);
    }

    /**
     * test getMessage with the <code>unknown_element</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageUnknownElement() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.ERROR,
            "unknown_element",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Error: <test> is not recognized!", message);
    }

    /**
     * test getMessage with the <code>unexpected_endtag</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageUnexpectedEndtag() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.ERROR,
            "unexpected_endtag",
            new Object[]{"test"});
        assertEquals("line 12 column 34 - Error: unexpected </test>", message);
    }

    /**
     * test getMessage with the <code>unexpected_endtag_in</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageUnexpectedEndtagIn() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.ERROR,
            "unexpected_endtag_in",
            new Object[]{"test", "bee"});
        assertEquals("line 12 column 34 - Error: unexpected </test> in <bee>", message);
    }

    /**
     * test getMessage with the <code>too_many_elements</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageTooManyElements() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "too_many_elements",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Warning: too many <test> elements", message);
    }

    /**
     * test getMessage with the <code>too_many_elements_in</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageTooManyElementsIn() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "too_many_elements_in",
            new Object[]{"<test>", "bee"});
        assertEquals("line 12 column 34 - Warning: too many <test> elements in <bee>", message);
    }

    /**
     * test getMessage with the <code>unknown_attribute</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageUnknownAttribute() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "unknown_attribute",
            new Object[]{"test"});
        assertEquals("line 12 column 34 - Warning: unknown attribute \"test\"", message);
    }

    /**
     * test getMessage with the <code>missing_attribute</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageMissingAttribute() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "missing_attribute",
            new Object[]{"<test>", "bee"});
        assertEquals("line 12 column 34 - Warning: <test> lacks \"bee\" attribute", message);
    }

    /**
     * test getMessage with the <code>missing_attr_value</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageMissingAttrValue() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "missing_attr_value",
            new Object[]{"<test>", "bee"});
        assertEquals("line 12 column 34 - Warning: <test> attribute \"bee\" lacks value", message);
    }

    /**
     * test getMessage with the <code>missing_imagemap</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageMissingImagemap() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "missing_imagemap",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Warning: <test> should use client-side image map", message);
    }

    /**
     * test getMessage with the <code>bad_attribute_value</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageBadAttributeValue() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "bad_attribute_value",
            new Object[]{"<test>", "bee", "ant"});
        assertEquals("line 12 column 34 - Warning: <test> attribute \"bee\" has invalid value \"ant\"", message);
    }

    /**
     * test getMessage with the <code>xml_attribute_value</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageXmlAttributeValue() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "xml_attribute_value",
            new Object[]{"<test>", "bee"});
        assertEquals("line 12 column 34 - Warning: <test> has XML attribute \"bee\"", message);
    }

    /**
     * test getMessage with the <code>unexpected_gt</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageUnexpectedGt() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.ERROR,
            "unexpected_gt",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Error: <test> missing '>' for end of tag", message);
    }

    /**
     * test getMessage with the <code>unexpected_quotemark</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageUnexpectedQuotemark() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "unexpected_quotemark",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Warning: <test> unexpected or duplicate quote mark", message);
    }

    /**
     * test getMessage with the <code>repeated_attribute</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageRepeatedAttribute() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "repeated_attribute",
            new Object[]{"<test>", "bee", "ant"});
        assertEquals(
            "line 12 column 34 - Warning: <test> dropping value \"bee\" for repeated attribute \"ant\"",
            message);
    }

    /**
     * test getMessage with the <code>proprietary_attr_value</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageProprietaryAttrValue() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "proprietary_attr_value",
            new Object[]{"<test>", "bee"});
        assertEquals("line 12 column 34 - Warning: <test> proprietary attribute value \"bee\"", message);
    }

    /**
     * test getMessage with the <code>proprietary_attribute</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageProprietaryAttribute() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "proprietary_attribute",
            new Object[]{"<test>", "bee"});
        assertEquals("line 12 column 34 - Warning: <test> proprietary attribute \"bee\"", message);
    }

    /**
     * test getMessage with the <code>id_name_mismatch</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageIdNameMismatch() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            TidyMessage.Level.WARNING,
            "id_name_mismatch",
            new Object[]{"<test>"});
        assertEquals("line 12 column 34 - Warning: <test> id and name attribute value mismatch", message);
    }

    /**
     * test getMessage with the <code>missing_doctype</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageMissingDoctype() throws Exception
    {
        final String message = this.report.getMessageLexer(-1, lexer, TidyMessage.Level.WARNING, "missing_doctype", (Object[])null);
        assertEquals("line 12 column 34 - Warning: missing <!DOCTYPE> declaration", message);
    }

    /**
     * test getMessage with the <code>doctype_given</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageDoctypeGiven() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            null,
            "doctype_given",
            new Object[]{"bee"});
        assertEquals("Doctype given is \"bee\"", message);
    }

    /**
     * test getMessage with the <code>report_version</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageReportVersion() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            null,
            "report_version",
            new Object[]{"bee"});
        assertEquals("Document content looks like bee", message);
    }

    /**
     * test getMessage with the <code>xml_attribute_value</code> key.
     * @throws Exception any Exception generated during test
     */
    public void testGetMessageNumWarning() throws Exception
    {
        final String message = this.report.getMessageLexer(
            -1,
            lexer,
            null,
            "num_warnings",
            new Object[]{new Integer(0), new Integer(33)});
        assertEquals("0 warnings, 33 errors were found!", message);
    }

}