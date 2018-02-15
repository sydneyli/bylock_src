package group.pals.android.lib.ui.filechooser.p009a;

import android.content.Context;
import group.pals.android.lib.ui.filechooser.am;
import group.pals.android.lib.ui.filechooser.ax;
import group.pals.android.lib.ui.filechooser.bb;
import group.pals.android.lib.ui.filechooser.be;
import group.pals.android.lib.ui.filechooser.services.C0256f;

/* compiled from: MyApp */
public class C0223a extends C0222c {
    public static am m1757a(Context context) {
        return am.List.ordinal() == C0222c.m1756i(context).getInt(context.getString(be.afc_pkey_display_view_type), context.getResources().getInteger(bb.afc_pkey_display_view_type_def)) ? am.List : am.Grid;
    }

    public static void m1758a(Context context, am amVar) {
        String string = context.getString(be.afc_pkey_display_view_type);
        if (amVar == null) {
            C0222c.m1756i(context).edit().putInt(string, context.getResources().getInteger(bb.afc_pkey_display_view_type_def)).commit();
        } else {
            C0222c.m1756i(context).edit().putInt(string, amVar.ordinal()).commit();
        }
    }

    public static C0256f m1762b(Context context) {
        for (C0256f c0256f : C0256f.values()) {
            if (c0256f.ordinal() == C0222c.m1756i(context).getInt(context.getString(be.afc_pkey_display_sort_type), context.getResources().getInteger(bb.afc_pkey_display_sort_type_def))) {
                return c0256f;
            }
        }
        return C0256f.SortByName;
    }

    public static void m1759a(Context context, C0256f c0256f) {
        String string = context.getString(be.afc_pkey_display_sort_type);
        if (c0256f == null) {
            C0222c.m1756i(context).edit().putInt(string, context.getResources().getInteger(bb.afc_pkey_display_sort_type_def)).commit();
        } else {
            C0222c.m1756i(context).edit().putInt(string, c0256f.ordinal()).commit();
        }
    }

    public static boolean m1763c(Context context) {
        return C0222c.m1756i(context).getBoolean(context.getString(be.afc_pkey_display_sort_ascending), context.getResources().getBoolean(ax.afc_pkey_display_sort_ascending_def));
    }

    public static void m1760a(Context context, Boolean bool) {
        if (bool == null) {
            bool = Boolean.valueOf(context.getResources().getBoolean(ax.afc_pkey_display_sort_ascending_def));
        }
        C0222c.m1756i(context).edit().putBoolean(context.getString(be.afc_pkey_display_sort_ascending), bool.booleanValue()).commit();
    }

    public static boolean m1764d(Context context) {
        return C0222c.m1756i(context).getBoolean(context.getString(be.afc_pkey_display_show_time_for_old_days_this_year), context.getResources().getBoolean(ax.afc_pkey_display_show_time_for_old_days_this_year_def));
    }

    public static boolean m1765e(Context context) {
        return C0222c.m1756i(context).getBoolean(context.getString(be.afc_pkey_display_show_time_for_old_days), context.getResources().getBoolean(ax.afc_pkey_display_show_time_for_old_days_def));
    }

    public static boolean m1766f(Context context) {
        return C0222c.m1756i(context).getBoolean(context.getString(be.afc_pkey_display_remember_last_location), context.getResources().getBoolean(ax.afc_pkey_display_remember_last_location_def));
    }

    public static String m1767g(Context context) {
        return C0222c.m1756i(context).getString(context.getString(be.afc_pkey_display_last_location), null);
    }

    public static void m1761a(Context context, String str) {
        C0222c.m1756i(context).edit().putString(context.getString(be.afc_pkey_display_last_location), str).commit();
    }
}
