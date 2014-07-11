package com.cividle.core;

/**
 *
 * @author Whiplash
 */
public interface PlatformDependencyResolver {
    /* 
     The platform dependcy resolver is used to store platform dependent code.
     Methods declared here will be implemented by classes in the respective
     platform projects with the platform dependent code. Any classes in the 
     core project will call these methods.
     */

    public void PrintPlatform();

    public String Timestamp();

    public String FormatDecimalFormat(Float f);

    public String FormatDecimalFormat(Double d);
}
