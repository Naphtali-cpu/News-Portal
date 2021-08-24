import models.News;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public  class NewsTest{

    @Test
    public void Animal() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("Okay", testNews.getType());
    }
    @Test
    public void Animal2() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("Danger", testNews.getType2());
    }
    @Test
    public void Animal3() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("Safe", testNews.getType3());
    }
    @Test
    public void Animal4() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("Fine", testNews.getType4());
    }
    @Test
    public void Animal5() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("Risky", testNews.getType5());
    }

    @Test
    public void Animal6() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("Unpredicable", testNews.getType6());
    }
    @Test
    public void Animal7() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("friendly", testNews.getType7());
    }
    @Test
    public void Animal8() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("free", testNews.getType8());
    }
    @Test
    public void Animal9() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("unknown", testNews.getType9());
    }
    @Test
    public void Animal10() {
        News testEndanger = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("suspicious", testEndanger.getType10());
    }
    @Test
    public void Animal11() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("handled", testNews.getType11());
    }
    @Test
    public void Animal12() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("able", testNews.getType12());
    }
    @Test
    public void Animal13() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("unable", testNews.getType13());
    }
    @Test
    public void Animal14() {
        News testNews = new News("Okay", "Danger", "Safe", "Fine", "Risky", "Unpredicable", "friendly", "free", "unknown", "suspicious", "handled", "able", "unable", "vigorous");
        assertEquals("vigorous", testNews.getType14());
    }

}