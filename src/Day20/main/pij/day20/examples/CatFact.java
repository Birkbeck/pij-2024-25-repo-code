package pij.day20.examples;

/**
 * A CatFact encapsulates information about facts about cats as obtained from
 * the <a href="https://catfact.ninja/fact">https://catfact.ninja/fact</a>
 * RESTful web service.
 */
public class CatFact {

    private String fact;
    private int length;

    @Override
    public String toString() {
        return "CatFact [fact=" + this.fact + ", length=" + this.length + "]";
    }
}
