/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cividle.core;

/**
 *
 * @author Whiplash
 */
public interface PlatformDependencyResolver {

    public void PrintPlatform();

    public String Timestamp();

    public String FormatDecimalFormat(Float f);

    public String FormatDecimalFormat(Double d);
}
