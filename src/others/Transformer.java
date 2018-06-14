package others;

public interface Transformer<Source1, Target> {
    Target transform(Source1 source) throws Exception;
}
