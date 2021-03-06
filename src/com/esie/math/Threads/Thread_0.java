package com.esie.math.Threads;
import com.esie.core.ioc.MasterThread;
import com.esie.core.ui.elements.uiListItemHorizontal;
import com.esie.math.Forms.ColorSelectForm;
import java.util.ArrayList;
import java.util.List;
import static com.esie.core.ioc.parents.Window.windowStack;
import static com.esie.core.ui.elements.uiListItemHorizontal.ListItemHorizontalStack;
import static com.esie.core.ui.elements.uiSwitch.SwitchStack;
import static com.esie.math.UI.uiMainLayer.*;
import static java.lang.Math.*;

public class Thread_0 extends MasterThread {

    private boolean expanded = false;
    private static volatile String tab;

    @Override
    public void main() {

        if (!expanded && ListItemHorizontalStack.get("Open").answer == 1) {
            ListItemHorizontalStack.get("Open").answer = 0;
            windowStack.get("MainForm").destruct(ListItemHorizontalStack.get("Open"));
                List<String> args = new ArrayList<>();
                args.add("Sin");
                args.add("Cos");
                args.add("Tan");
                args.add("Atan");
                args.add("");
                args.add("");
                args.add("");
                args.add("");
                args.add("");
                args.add("");
                args.add("PIN GRAPH");

            windowStack.get("MainForm").construct(
                    new uiListItemHorizontal("Tabs", 5, 5, 11, args,100, true, 30));
            expanded = true;
        }

        if (expanded) {
            if (ListItemHorizontalStack.get("Tabs").answer == 1) {
                ListItemHorizontalStack.get("Tabs").answer = 0;
                tab = "sin";
                uiLayer.Clear();
                if (SwitchStack.get("Sync").returnAnswer <= 0) {
                    new Thread(() -> {
                        for (double i = -10; i <= 10; ) {
                            i += 0.003;
                            double y = (sin(i));
                            uiLayer.Set(i, y);
                        }
                    }).run();
                }
            }

            if (ListItemHorizontalStack.get("Tabs").answer == 2) {
                ListItemHorizontalStack.get("Tabs").answer = 0;
                tab = "cos";
                uiLayer.Clear();
                if (SwitchStack.get("Sync").returnAnswer <= 0) {
                    new Thread(() -> {
                        for (double i = -10; i <= 10; ) {
                            i += 0.003;
                            double y = (cos(i));
                            uiLayer.Set(i, y);
                        }
                    }).run();
                }
            }

            if (ListItemHorizontalStack.get("Tabs").answer == 3) {
                ListItemHorizontalStack.get("Tabs").answer = 0;
                tab = "tan";
                uiLayer.Clear();
                if (SwitchStack.get("Sync").returnAnswer <= 0) {
                    new Thread(() -> {
                        for (double i = -10; i <= 10; ) {
                            i += 0.003;
                            double y = (tan(i));
                            uiLayer.Set(i, y);
                        }
                    }).run();
                }
            }

            if (ListItemHorizontalStack.get("Tabs").answer == 4) {
                ListItemHorizontalStack.get("Tabs").answer = 0;
                tab = "atan";
                uiLayer.Clear();
                if (SwitchStack.get("Sync").returnAnswer <= 0) {
                    new Thread(() -> {
                        for (double i = -10; i <= 10; ) {
                            i += 0.003;
                            double y = (atan(i));
                            uiLayer.Set(i, y);
                        }
                    }).run();
                }
            }

            if (ListItemHorizontalStack.get("Tabs").answer == 11) {
                ListItemHorizontalStack.get("Tabs").answer = 0;
                new ColorSelectForm("ColorSelect");
            }
        }
    }
}
