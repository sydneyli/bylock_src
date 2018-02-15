package group.pals.android.lib.ui.filechooser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.p009a.C0223a;
import group.pals.android.lib.ui.filechooser.services.C0251c;
import group.pals.android.lib.ui.filechooser.services.C0254d;
import group.pals.android.lib.ui.filechooser.services.C0255e;
import group.pals.android.lib.ui.filechooser.services.C0256f;
import group.pals.android.lib.ui.filechooser.services.LocalFileProvider;
import group.pals.android.lib.ui.filechooser.utils.C0271a;
import group.pals.android.lib.ui.filechooser.utils.C0276f;
import group.pals.android.lib.ui.filechooser.utils.C0280i;
import group.pals.android.lib.ui.filechooser.utils.history.C0227a;
import group.pals.android.lib.ui.filechooser.utils.history.History;
import group.pals.android.lib.ui.filechooser.utils.history.HistoryStore;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0226i;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0263d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MyApp */
public class FileChooserActivity extends Activity {
    private static final int[] f1039L = new int[]{ba.afc_settings_sort_view_button_sort_by_name_asc, ba.afc_settings_sort_view_button_sort_by_name_desc, ba.afc_settings_sort_view_button_sort_by_size_asc, ba.afc_settings_sort_view_button_sort_by_size_desc, ba.afc_settings_sort_view_button_sort_by_date_asc, ba.afc_settings_sort_view_button_sort_by_date_desc};
    private static /* synthetic */ int[] f1040X;
    private static /* synthetic */ int[] f1041Y;
    private static /* synthetic */ int[] f1042Z;
    public static final String f1043a = FileChooserActivity.class.getName();
    public static final String f1044b = (f1043a + ".theme");
    public static final String f1045c = (f1043a + ".rootpath");
    public static final String f1046d = (f1043a + ".file_provider_class");
    public static final String f1047e = C0254d.class.getName();
    public static final String f1048f = (f1043a + ".max_file_count");
    public static final String f1049g = (f1043a + ".multi_selection");
    public static final String f1050h = (f1043a + ".regex_filename_filter");
    public static final String f1051i = (f1043a + ".display_hidden_files");
    public static final String f1052j = (f1043a + ".double_tap_to_choose_files");
    public static final String f1053k = (f1043a + ".select_file");
    public static final String f1054l = (f1043a + ".save_dialog");
    public static final String f1055m = (f1043a + ".default_filename");
    public static final String f1056n = (f1043a + ".results");
    static final String f1057o = (f1043a + ".current_location");
    static final String f1058p = (f1043a + ".history");
    static final String f1059q = new StringBuilder(String.valueOf(History.class.getName())).append("_full").toString();
    private an f1060A;
    private HorizontalScrollView f1061B;
    private ViewGroup f1062C;
    private ViewGroup f1063D;
    private TextView f1064E;
    private AbsListView f1065F;
    private TextView f1066G;
    private Button f1067H;
    private EditText f1068I;
    private ImageView f1069J;
    private ImageView f1070K;
    private final OnClickListener f1071M = new C0225a(this);
    private final OnClickListener f1072N = new C0244m(this);
    private final OnLongClickListener f1073O = new aa(this);
    private final OnClickListener f1074P = new ac(this);
    private final OnLongClickListener f1075Q = new ae(this);
    private final OnEditorActionListener f1076R = new ai(this);
    private final OnClickListener f1077S = new aj(this);
    private final OnClickListener f1078T = new ak(this);
    private GestureDetector f1079U;
    private final OnItemClickListener f1080V = new al(this);
    private final OnItemLongClickListener f1081W = new C0232c(this);
    private Class f1082r;
    private C0251c f1083s;
    private ServiceConnection f1084t;
    private IFile f1085u;
    private boolean f1086v;
    private boolean f1087w;
    private boolean f1088x;
    private History f1089y;
    private History f1090z;

    static /* synthetic */ int[] m1708a() {
        int[] iArr = f1040X;
        if (iArr == null) {
            iArr = new int[C0256f.values().length];
            try {
                iArr[C0256f.SortByDate.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C0256f.SortByName.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C0256f.SortBySize.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            f1040X = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] m1714b() {
        int[] iArr = f1041Y;
        if (iArr == null) {
            iArr = new int[am.values().length];
            try {
                iArr[am.Grid.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[am.List.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            f1041Y = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] m1716c() {
        int[] iArr = f1042Z;
        if (iArr == null) {
            iArr = new int[C0254d.values().length];
            try {
                iArr[C0254d.DirectoriesOnly.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C0254d.FilesAndDirectories.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C0254d.FilesOnly.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            f1042Z = iArr;
        }
        return iArr;
    }

    public void onCreate(Bundle bundle) {
        if (getIntent().hasExtra(f1044b)) {
            int intExtra;
            if (VERSION.SDK_INT >= 14) {
                intExtra = getIntent().getIntExtra(f1044b, 16974120);
            } else if (VERSION.SDK_INT >= 11) {
                intExtra = getIntent().getIntExtra(f1044b, 16973931);
            } else {
                intExtra = getIntent().getIntExtra(f1044b, 16973829);
            }
            setTheme(intExtra);
        }
        super.onCreate(bundle);
        setContentView(bc.afc_file_chooser);
        m1745r();
        this.f1082r = (Class) getIntent().getSerializableExtra(f1046d);
        if (this.f1082r == null) {
            this.f1082r = LocalFileProvider.class;
        }
        this.f1086v = getIntent().getBooleanExtra(f1049g, false);
        this.f1087w = getIntent().getBooleanExtra(f1054l, false);
        if (this.f1087w) {
            this.f1086v = false;
        }
        this.f1088x = getIntent().getBooleanExtra(f1052j, false);
        this.f1069J = (ImageView) findViewById(ba.afc_filechooser_activity_button_go_back);
        this.f1070K = (ImageView) findViewById(ba.afc_filechooser_activity_button_go_forward);
        this.f1062C = (ViewGroup) findViewById(ba.afc_filechooser_activity_view_locations);
        this.f1061B = (HorizontalScrollView) findViewById(ba.afc_filechooser_activity_view_locations_container);
        this.f1064E = (TextView) findViewById(ba.afc_filechooser_activity_textview_full_dir_name);
        this.f1063D = (ViewGroup) findViewById(ba.afc_filechooser_activity_view_files_container);
        this.f1066G = (TextView) findViewById(ba.afc_filechooser_activity_view_files_footer_view);
        this.f1068I = (EditText) findViewById(ba.afc_filechooser_activity_textview_saveas_filename);
        this.f1067H = (Button) findViewById(ba.afc_filechooser_activity_button_ok);
        if (bundle == null || !(bundle.get(f1058p) instanceof HistoryStore)) {
            this.f1089y = new HistoryStore(51);
        } else {
            this.f1089y = (History) bundle.getParcelable(f1058p);
        }
        this.f1089y.mo279a(new C0234d(this));
        if (bundle == null || !(bundle.get(f1059q) instanceof HistoryStore)) {
            this.f1090z = new HistoryStore(this, 51) {
                final /* synthetic */ FileChooserActivity f1038a;

                public void m1690a(IFile iFile) {
                    int d = m1681d((Parcelable) iFile);
                    if (d >= 0) {
                        if (d != mo277a() - 1) {
                            m1678c((Parcelable) iFile);
                        } else {
                            return;
                        }
                    }
                    super.mo290a((Parcelable) iFile);
                }
            };
        } else {
            this.f1090z = (History) bundle.getParcelable(f1059q);
        }
        setResult(0);
        m1692a(bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(bd.afc_file_chooser_activity, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean c = C0223a.m1763c(this);
        MenuItem findItem = menu.findItem(ba.afc_filechooser_activity_menuitem_sort);
        int i;
        switch (m1708a()[C0223a.m1762b(this).ordinal()]) {
            case 1:
                if (c) {
                    i = az.afc_ic_menu_sort_by_name_asc;
                } else {
                    i = az.afc_ic_menu_sort_by_name_desc;
                }
                findItem.setIcon(i);
                break;
            case 2:
                if (c) {
                    i = az.afc_ic_menu_sort_by_size_asc;
                } else {
                    i = az.afc_ic_menu_sort_by_size_desc;
                }
                findItem.setIcon(i);
                break;
            case 3:
                if (c) {
                    i = az.afc_ic_menu_sort_by_date_asc;
                } else {
                    i = az.afc_ic_menu_sort_by_date_desc;
                }
                findItem.setIcon(i);
                break;
        }
        MenuItem findItem2 = menu.findItem(ba.afc_filechooser_activity_menuitem_switch_viewmode);
        switch (m1714b()[C0223a.m1757a(this).ordinal()]) {
            case 1:
                findItem2.setIcon(az.afc_ic_menu_gridview);
                findItem2.setTitle(be.afc_cmd_grid_view);
                break;
            case 2:
                findItem2.setIcon(az.afc_ic_menu_listview);
                findItem2.setTitle(be.afc_cmd_list_view);
                break;
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getGroupId() == ba.afc_filechooser_activity_menugroup_sorter) {
            m1733l();
        } else if (menuItem.getItemId() == ba.afc_filechooser_activity_menuitem_new_folder) {
            m1739o();
        } else if (menuItem.getItemId() == ba.afc_filechooser_activity_menuitem_switch_viewmode) {
            m1737n();
        } else if (menuItem.getItemId() == ba.afc_filechooser_activity_menuitem_home) {
            m1732k();
        } else if (menuItem.getItemId() == ba.afc_filechooser_activity_menuitem_reload) {
            m1728i();
        }
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(f1057o, m1741p());
        bundle.putParcelable(f1058p, this.f1089y);
        bundle.putParcelable(f1059q, this.f1090z);
    }

    protected void onStart() {
        super.onStart();
        if (!this.f1086v && !this.f1087w && this.f1088x) {
            C0263d.m1874a((Context) this, be.afc_hint_double_tap_to_select_file, 0);
        }
    }

    protected void onDestroy() {
        if (this.f1083s != null) {
            try {
                unbindService(this.f1084t);
            } catch (Throwable th) {
                Log.e(f1043a, "onDestroy() - unbindService() - exception: " + th);
            }
            try {
                stopService(new Intent(this, this.f1082r));
            } catch (SecurityException e) {
            }
        }
        super.onDestroy();
    }

    private void m1692a(Bundle bundle) {
        if (startService(new Intent(this, this.f1082r)) == null) {
            m1730j();
            return;
        }
        this.f1084t = new C0235e(this);
        bindService(new Intent(this, this.f1082r), this.f1084t, 1);
        new C0236f(this, this, be.afc_msg_loading, false, bundle).execute(new Void[0]);
    }

    private void m1718d() {
        C0255e c0255e;
        if (getIntent().getParcelableExtra(f1045c) != null) {
            this.f1085u = (IFile) getIntent().getSerializableExtra(f1045c);
        }
        if (this.f1085u == null || !this.f1085u.isDirectory()) {
            this.f1085u = this.f1083s.mo316g();
        }
        C0254d c0254d = (C0254d) getIntent().getSerializableExtra(f1047e);
        if (c0254d == null) {
            c0254d = C0254d.FilesOnly;
        }
        C0256f b = C0223a.m1762b(this);
        boolean c = C0223a.m1763c(this);
        this.f1083s.mo307a(getIntent().getBooleanExtra(f1051i, false));
        C0251c c0251c = this.f1083s;
        if (this.f1087w) {
            c0254d = C0254d.FilesOnly;
        }
        c0251c.mo303a(c0254d);
        this.f1083s.mo302a(getIntent().getIntExtra(f1048f, 1024));
        this.f1083s.mo306a(this.f1087w ? null : getIntent().getStringExtra(f1050h));
        c0251c = this.f1083s;
        if (c) {
            c0255e = C0255e.Ascending;
        } else {
            c0255e = C0255e.Descending;
        }
        c0251c.mo304a(c0255e);
        this.f1083s.mo305a(b);
    }

    private void m1720e() {
        int i = 0;
        if (!this.f1087w) {
            switch (m1716c()[this.f1083s.mo308c().ordinal()]) {
                case 1:
                    setTitle(be.afc_title_choose_files);
                    break;
                case 2:
                    setTitle(be.afc_title_choose_directories);
                    break;
                case 3:
                    setTitle(be.afc_title_choose_files_and_directories);
                    break;
                default:
                    break;
            }
        }
        setTitle(be.afc_title_save_as);
        this.f1069J.setEnabled(false);
        this.f1069J.setOnClickListener(this.f1071M);
        this.f1070K.setEnabled(false);
        this.f1070K.setOnClickListener(this.f1074P);
        ImageView[] imageViewArr = new ImageView[]{this.f1069J, this.f1070K};
        int length = imageViewArr.length;
        while (i < length) {
            imageViewArr[i].setOnLongClickListener(this.f1075Q);
            i++;
        }
    }

    private void m1722f() {
        switch (m1714b()[C0223a.m1757a(this).ordinal()]) {
            case 1:
                this.f1065F = (AbsListView) getLayoutInflater().inflate(bc.afc_listview_files, null);
                break;
            case 2:
                this.f1065F = (AbsListView) getLayoutInflater().inflate(bc.afc_gridview_files, null);
                break;
        }
        this.f1063D.removeAllViews();
        this.f1063D.addView(this.f1065F, new LayoutParams(-1, -1, 1.0f));
        this.f1065F.setOnItemClickListener(this.f1080V);
        this.f1065F.setOnItemLongClickListener(this.f1081W);
        this.f1065F.setOnTouchListener(new C0238h(this));
        m1723g();
        this.f1066G.setOnLongClickListener(new C0239i(this));
    }

    private void m1723g() {
        if (this.f1060A != null) {
            this.f1060A.m1794b();
        }
        this.f1060A = new an(this, new ArrayList(), this.f1083s.mo308c(), this.f1086v);
        if (this.f1065F instanceof ListView) {
            ((ListView) this.f1065F).setAdapter(this.f1060A);
        } else {
            ((GridView) this.f1065F).setAdapter(this.f1060A);
        }
    }

    private void m1726h() {
        ViewGroup viewGroup = (ViewGroup) findViewById(ba.afc_filechooser_activity_viewgroup_footer_container);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(ba.afc_filechooser_activity_viewgroup_footer);
        if (this.f1087w) {
            viewGroup.setVisibility(0);
            viewGroup2.setVisibility(0);
            this.f1068I.setVisibility(0);
            this.f1068I.setText(getIntent().getStringExtra(f1055m));
            this.f1068I.setOnEditorActionListener(this.f1076R);
            this.f1067H.setVisibility(0);
            this.f1067H.setOnClickListener(this.f1077S);
            this.f1067H.setBackgroundResource(az.afc_selector_button_ok_saveas);
            int dimensionPixelSize = getResources().getDimensionPixelSize(ay.afc_button_ok_saveas_size);
            LayoutParams layoutParams = (LayoutParams) this.f1067H.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            this.f1067H.setLayoutParams(layoutParams);
        } else if (this.f1086v) {
            viewGroup.setVisibility(0);
            viewGroup2.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
            layoutParams2.width = -2;
            viewGroup2.setLayoutParams(layoutParams2);
            this.f1067H.setMinWidth(getResources().getDimensionPixelSize(ay.afc_single_button_min_width));
            this.f1067H.setText(17039370);
            this.f1067H.setVisibility(0);
            this.f1067H.setOnClickListener(this.f1078T);
        }
    }

    private void m1728i() {
        m1701a(m1741p(), null);
    }

    private void m1730j() {
        C0263d.m1875a((Context) this, be.afc_msg_cannot_connect_to_file_provider_service, new C0241j(this));
    }

    private void m1732k() {
        m1707a(this.f1085u.mo299b());
    }

    private void m1733l() {
        int i;
        int i2;
        AlertDialog a = C0263d.m1873a(this);
        switch (m1708a()[C0223a.m1762b(this).ordinal()]) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 4;
                break;
            default:
                i = 0;
                break;
        }
        if (C0223a.m1763c(this)) {
            i2 = i;
        } else {
            i2 = i + 1;
        }
        OnClickListener c0242k = new C0242k(this, a);
        View inflate = getLayoutInflater().inflate(bc.afc_settings_sort_view, null);
        for (int i3 = 0; i3 < f1039L.length; i3++) {
            Button button = (Button) inflate.findViewById(f1039L[i3]);
            button.setOnClickListener(c0242k);
            if (i3 == i2) {
                button.setEnabled(false);
                if (VERSION.SDK_INT >= 11) {
                    button.setText(be.afc_ellipsize);
                }
            }
        }
        a.setTitle(be.afc_title_sort_by);
        a.setView(inflate);
        a.show();
    }

    private void m1735m() {
        if (!this.f1083s.mo309d().equals(C0223a.m1762b(this)) || this.f1083s.mo310e().m1868a() != C0223a.m1763c(this)) {
            this.f1083s.mo305a(C0223a.m1762b(this));
            this.f1083s.mo304a(C0223a.m1763c(this) ? C0255e.Ascending : C0255e.Descending);
            m1728i();
            if (VERSION.SDK_INT >= 11) {
                C0271a.m1882a(this);
            }
        }
    }

    private void m1737n() {
        new C0243l(this, this, be.afc_msg_loading, false).execute(new Void[0]);
    }

    private void m1739o() {
        if (this.f1083s instanceof LocalFileProvider) {
            if (!C0280i.m1896a(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                C0263d.m1874a((Context) this, be.afc_msg_app_doesnot_have_permission_to_create_files, 0);
                return;
            }
        }
        AlertDialog a = C0263d.m1873a(this);
        View inflate = getLayoutInflater().inflate(bc.afc_simple_text_input_view, null);
        EditText editText = (EditText) inflate.findViewById(ba.afc_simple_text_input_view_text1);
        editText.setHint(be.afc_hint_folder_name);
        editText.setOnEditorActionListener(new C0245n(this, editText, a));
        a.setView(inflate);
        a.setTitle(be.afc_cmd_new_folder);
        a.setIcon(17301555);
        a.setButton(-1, getString(17039370), new C0246o(this, editText));
        a.show();
        Button button = a.getButton(-1);
        button.setEnabled(false);
        editText.addTextChangedListener(new C0247p(this, button));
    }

    private void m1700a(av avVar) {
        avVar.m1812b(false);
        this.f1060A.notifyDataSetChanged();
    }

    private void m1712b(av avVar) {
        String string;
        if (this.f1083s instanceof LocalFileProvider) {
            if (!C0280i.m1896a(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                m1700a(avVar);
                C0263d.m1874a((Context) this, be.afc_msg_app_doesnot_have_permission_to_delete_files, 0);
                return;
            }
        }
        int i = be.afc_pmsg_confirm_delete_file;
        Object[] objArr = new Object[2];
        if (avVar.m1810a().isFile()) {
            string = getString(be.afc_file);
        } else {
            string = getString(be.afc_folder);
        }
        objArr[0] = string;
        objArr[1] = avVar.m1810a().getName();
        C0263d.m1879a(this, getString(i, objArr), new C0248q(this, avVar), new C0250s(this, avVar));
    }

    private void m1703a(String str) {
        if (str.length() == 0) {
            C0263d.m1874a((Context) this, be.afc_msg_filename_is_empty, 0);
            return;
        }
        IFile b = this.f1083s.mo314b(new StringBuilder(String.valueOf(m1741p().getAbsolutePath())).append(File.separator).append(str).toString());
        if (!C0276f.m1891a(str)) {
            C0263d.m1876a((Context) this, getString(be.afc_pmsg_filename_is_invalid, new Object[]{str}), 0);
        } else if (b.isFile()) {
            C0263d.m1878a((Context) this, getString(be.afc_pmsg_confirm_replace_file, new Object[]{b.getName()}), new C0259t(this, b));
        } else if (b.isDirectory()) {
            C0263d.m1876a((Context) this, getString(be.afc_pmsg_filename_is_directory, new Object[]{b.getName()}), 0);
        } else {
            m1705a(b);
        }
    }

    private IFile m1741p() {
        return (IFile) this.f1062C.getTag();
    }

    private void m1701a(IFile iFile, C0226i c0226i) {
        m1702a(iFile, c0226i, null);
    }

    private void m1702a(IFile iFile, C0226i c0226i, IFile iFile2) {
        new C0260u(this, this, be.afc_msg_loading, true, iFile, iFile2, c0226i).execute(new Void[0]);
    }

    private boolean m1707a(IFile iFile) {
        if (iFile.mo298a(m1741p())) {
            return false;
        }
        m1701a(iFile, new C0283x(this, iFile));
        return true;
    }

    private void m1713b(IFile iFile) {
        this.f1062C.setTag(iFile);
        this.f1062C.removeAllViews();
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        LayoutInflater layoutInflater = getLayoutInflater();
        int dimensionPixelSize = getResources().getDimensionPixelSize(ay.afc_5dp);
        int i = 0;
        ViewGroup viewGroup = null;
        while (iFile != null) {
            CharSequence name;
            TextView textView = (TextView) layoutInflater.inflate(bc.afc_button_location, null);
            if (iFile.mo297a() != null) {
                name = iFile.getName();
            } else {
                name = getString(be.afc_root);
            }
            textView.setText(name);
            textView.setTag(iFile);
            textView.setOnClickListener(this.f1072N);
            textView.setOnLongClickListener(this.f1073O);
            this.f1062C.addView(textView, 0, layoutParams);
            int i2 = i + 1;
            if (i == 0) {
                Rect rect = new Rect();
                textView.getPaint().getTextBounds(iFile.getName(), 0, iFile.getName().length(), rect);
                if (rect.width() >= (getResources().getDimensionPixelSize(ay.afc_button_location_max_width) - textView.getPaddingLeft()) - textView.getPaddingRight()) {
                    this.f1064E.setText(iFile.getName());
                    this.f1064E.setVisibility(0);
                } else {
                    this.f1064E.setVisibility(8);
                }
            }
            iFile = iFile.mo297a();
            if (iFile != null) {
                ViewGroup.LayoutParams layoutParams2;
                View inflate = layoutInflater.inflate(bc.afc_view_locations_divider, null);
                if (viewGroup == null) {
                    layoutParams2 = new LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams2.gravity = 17;
                    layoutParams2.setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                } else {
                    Object obj = viewGroup;
                }
                this.f1062C.addView(inflate, 0, layoutParams2);
                i = i2;
                viewGroup = layoutParams2;
            } else {
                i = i2;
            }
        }
        this.f1061B.postDelayed(new C0284y(this), 100);
    }

    private void m1743q() {
        C0227a c0285z = new C0285z(this);
        this.f1089y.mo278a(c0285z);
        this.f1090z.mo278a(c0285z);
    }

    private void m1705a(IFile... iFileArr) {
        List arrayList = new ArrayList();
        for (Object add : iFileArr) {
            arrayList.add(add);
        }
        m1704a((ArrayList) arrayList);
    }

    private void m1704a(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            setResult(0);
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(f1056n, arrayList);
        intent.putExtra(f1047e, this.f1083s.mo308c());
        intent.putExtra(f1054l, this.f1087w);
        setResult(-1, intent);
        if (!C0223a.m1766f(this) || m1741p() == null) {
            C0223a.m1761a((Context) this, null);
        } else {
            C0223a.m1761a((Context) this, m1741p().getAbsolutePath());
        }
        finish();
    }

    private void m1745r() {
        this.f1079U = new GestureDetector(this, new ab(this));
    }
}
