package at.stefangeyer.challonge.async;

import java.util.function.Consumer;

/**
 * Generic callback used for async calls
 *
 * @param <T> T is usually either an instance of a model class or an exception if the call failed
 * @author Stefan Geyer
 * @version 2018-07-02
 */
public interface Callback<T> extends Consumer<T> {
}