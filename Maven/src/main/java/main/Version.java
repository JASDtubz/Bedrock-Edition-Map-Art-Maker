/*
    Copyright Loshun Ltd. 2022
    Updated Tuesday, May 31
    Version 1.1.0
*/

package main;

/**
 * This is a practice file and should be ignored
 */
public @interface Version
{
    boolean required() default false;

    double addedIn() default 0.0;

    double lastEdited() default 0.0;
}
