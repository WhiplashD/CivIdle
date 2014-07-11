package com.cividle.desktop;

import com.cividle.core.PlatformDependencyResolver;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Whiplash
 */
public class DesktopPlatform implements PlatformDependencyResolver {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    private final DecimalFormat df = new DecimalFormat("###,###.##");

    @Override
    public void PrintPlatform() {
        System.out.println("Desktop");
    }

    @Override
    public String Timestamp() {
        return "[" + sdf.format(new Date()) + "] ";
    }

    @Override
    public String FormatDecimalFormat(Float f) {
        return df.format(f);
    }
    @Override
    public String FormatDecimalFormat(Double d) {
        return df.format(d);
    }
}
