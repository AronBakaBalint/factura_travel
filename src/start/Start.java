// 
// Decompiled by Procyon v0.5.36
// 

package start;

import view.Controller;
import view.View;

public class Start
{
    public static void main(final String[] args) {
        final View v = new View();
        v.setVisible(true);
        new Controller(v);
    }
}
