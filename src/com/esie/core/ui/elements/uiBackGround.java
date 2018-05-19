package com.esie.core.ui.elements;
import java.awt.Graphics;
import com.esie.core.eventObserver.Event;
import com.esie.core.ui.Element;

import static java.awt.Color.*;

final public class uiBackGround extends Element {

    @Override
    public void onEvent(Event e) {

    }


    @Override
    public void onRender(Graphics g) {
            g.setColor(LIGHT_GRAY);
            g.fillRect(0, 0, 1920, 1080);
    }


    @Override
    public void onDestroy() {

    }
}
