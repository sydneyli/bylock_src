package group.pals.android.lib.ui.filechooser.utils;

import group.pals.android.lib.ui.filechooser.az;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.services.C0251c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MyApp */
public class C0276f {
    private static final Map f1226a = new HashMap();

    static {
        f1226a.put("(?si).+\\.(mp[2-3]+|wav|aiff|au|m4a|ogg|raw|flac|mid|amr|aac|alac|atrac|awb|m4p|mmf|mpc|ra|rm|tta|vox|wma)", Integer.valueOf(az.afc_file_audio));
        f1226a.put("(?si).+\\.(mp[4]+|flv|wmv|webm|m4v|3gp|mkv|mov|mpe?g|rmv?|ogv|avi)", Integer.valueOf(az.afc_file_video));
        f1226a.put("(?si).+\\.(gif|jpe?g|png|tiff?|wmf|emf|jfif|exif|raw|bmp|ppm|pgm|pbm|pnm|webp|riff|tga|ilbm|img|pcx|ecw|sid|cd5|fits|pgf|xcf|svg|pns|jps|icon?|jp2|mng|xpm|djvu)", Integer.valueOf(az.afc_file_image));
        f1226a.put("(?si).+\\.(zip|7z|lz?|[jrt]ar|gz|gzip|bzip|xz|cab|sfx|z|iso|bz?|rz|s7z|apk|dmg)", Integer.valueOf(az.afc_file_compressed));
        f1226a.put("(?si).+\\.(txt|html?|json|csv|java|pas|php.*|c|cpp|bas|python|js|javascript|scala|xml|kml|css|ps|xslt?|tpl|tsv|bash|cmd|pl|pm|ps1|ps1xml|psc1|psd1|psm1|py|pyc|pyo|r|rb|sdl|sh|tcl|vbs|xpl|ada|adb|ads|clj|cls|cob|cbl|cxx|cs|csproj|d|e|el|go|h|hpp|hxx|l|m|url|ini|prop|conf|properties|rc)", Integer.valueOf(az.afc_file_plain_text));
    }

    public static int m1889a(IFile iFile) {
        if (iFile == null || !iFile.exists()) {
            return 17301533;
        }
        if (iFile.isFile()) {
            String name = iFile.getName();
            for (String str : f1226a.keySet()) {
                if (name.matches(str)) {
                    return ((Integer) f1226a.get(str)).intValue();
                }
            }
            return az.afc_file;
        } else if (iFile.isDirectory()) {
            return az.afc_folder;
        } else {
            return 17301533;
        }
    }

    public static boolean m1891a(String str) {
        return str != null && str.trim().matches("[^\\\\/?%*:|\"<>]+");
    }

    public static Thread m1890a(IFile iFile, C0251c c0251c, boolean z) {
        return new C0277g(iFile, z, c0251c);
    }
}
