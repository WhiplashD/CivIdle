package com.cividle.client;

import com.cividle.core.PlatformDependencyResolver;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;

/**
 *
 * @author Whiplash
 */
public class WebPlatform implements PlatformDependencyResolver {

    private static final DateTimeFormat dtf = DateTimeFormat.getFormat("hh:mm:ss");
    private static final NumberFormat nf = NumberFormat.getFormat("###,###.##");

    @Override
    public void PrintPlatform() {
        System.out.println("HTML5");
    }

    @Override
    public String Timestamp() {
        return " [" + dtf.format(new Date()) + " ]";
    }

    @Override
    public String FormatDecimalFormat(Float f) {
        return nf.format(f);
    }

    @Override
    public String FormatDecimalFormat(Double d) {
        return nf.format(d);
    }
}
