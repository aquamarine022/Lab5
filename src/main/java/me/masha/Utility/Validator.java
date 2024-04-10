package me.masha.Utility;

import me.masha.Exeptions.InvalidDataException;

/**
 * interface for validatable classes
 */
@FunctionalInterface
public interface Validator<T> {
    void validate(T value) throws InvalidDataException;
}
