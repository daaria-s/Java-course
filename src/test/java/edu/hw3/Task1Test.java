package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task1.atbash;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    void atbashSmallLettersTest() {
        assertEquals("svooldliow", atbash("helloworld"));
        assertEquals("vmerilmnvmg", atbash("environment"));
        assertEquals("qzez", atbash("java"));
        assertEquals("sld ziv blf", atbash("how are you"));
    }

    @Test
    void atbashCapitalLettersTest() {
        assertEquals("TLLWNLIMRMT", atbash("GOODMORNING"));
        assertEquals("XBKIFH", atbash("CYPRUS"));
        assertEquals("VMTRMVVIRMT", atbash("ENGINEERING"));
    }

    @Test
    void atbashNotLettersTest() {
        assertEquals("1234)&)%_#+)(&(", atbash("1234)&)%_#+)(&("));
        assertEquals("   ", atbash("   "));
        assertEquals("", atbash(""));
    }

    @Test
    void atbashMixedTest() {
        assertEquals("Hello world!", atbash("Svool dliow!"));
        assertEquals(
            "Any fool can write code that a computer can understand. Good programmers " +
                "write code that humans can understand. ― Martin Fowler",
            atbash(
                "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv " +
                    "xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi")
        );
        assertEquals(
            "Olivn rkhfn wloli hrg znvg, xlmhvxgvgfi zwrkrhxrmt vorg, hvw wl vrfhnlw gvnkli rmxrwrwfmg " +
                "fg ozyliv vg wloliv nztmz zorjfz.",
            atbash(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                    "ut labore et dolore magna aliqua.")
        );

    }
}
