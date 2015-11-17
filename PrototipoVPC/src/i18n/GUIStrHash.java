package i18n;

import java.util.HashMap;
import java.util.Map;

public abstract class GUIStrHash { 
    
    private static final Map<GUIStr, String> hash;
    static
    {
        hash = new HashMap<GUIStr, String>();
        hash.put(GUIStr.MAIN_WINDOW_TITLE, "MainWindow.Title");
        hash.put(GUIStr.FILE_MENU, "FileMenu");
        hash.put(GUIStr.FILE_MENU_OPEN_ACTION, "FileMenu.OpenAction");
        hash.put(GUIStr.FILE_MENU_SAVE_ACTION, "FileMenu.SaveAction");
        hash.put(GUIStr.FILE_MENU_SAVE_AS_ACTION, "FileMenu.SaveAsAction");
        hash.put(GUIStr.FILE_MENU_CLOSE_ACTION, "FileMenu.CloseAction");
        hash.put(GUIStr.FILE_MENU_QUIT_ACTION, "FileMenu.QuitAction");
        hash.put(GUIStr.FILE_DIALOG_OPEN, "FileDialog.Open");
        hash.put(GUIStr.FILE_DIALOG_SAVE_AS, "FileDialog.SaveAs");
        hash.put(GUIStr.STATUSBAR_COLOR_MODE_GRAYSCALE, "StatusBar.ColorModeGrayscale");
        hash.put(GUIStr.STATUSBAR_COLOR_MODE_RGB, "StatusBar.ColorModeRGB");
        hash.put(GUIStr.TRANSFORM_MENU, "TransformMenu");
        hash.put(GUIStr.TRANSFORM_MENU_EQUALIZE_ACTION, "TransformMenu.EqualizeAction");
        hash.put(GUIStr.TRANSFORM_MENU_NEGATIVE_ACTION, "TransformMenu.NegativeAction");
        hash.put(GUIStr.TRANSFORM_MENU_HISTOGRAM_EQUALIZATION, "TransformMenu.HistogramEqualization");
        hash.put(GUIStr.ANALYZE_MENU, "AnalyzeMenu");
        hash.put(GUIStr.ANALYZE_MENU_ABSOLUTE_HISTOGRAM, "AnalyzeMenu.AbsoluteHistogram");
        hash.put(GUIStr.ANALYZE_MENU_ACCUMULATIVE_HISTOGRAM, "AnalyzeMenu.AccumulativeHistogram");
        hash.put(GUIStr.OPTIONS_MENU, "OptionsMenu");
        hash.put(GUIStr.HISTOGRAM_LABEL_COLOR, "Histogram.LabelColor");
        hash.put(GUIStr.HISTOGRAM_LABEL_PIXELS, "Histogram.LabelPixels");
        hash.put(GUIStr.IMAGE_MENU, "ImageMenu");
        hash.put(GUIStr.IMAGE_MENU_CROP_SELECTION, "ImageMenu.CropSelection");
        hash.put(GUIStr.IMAGE_MENU_BRIGHTNESS_CONTRAST, "ImageMenu.BrightnessContrast");
        hash.put(GUIStr.IMAGE_MENU_TO_GRAYSCALE, "ImageMenu.ToGrayscale");
        hash.put(GUIStr.BRIGHTNESS_DIALOG_BRIGHTNESS, "BrightnessDialog.Brightness");
        hash.put(GUIStr.BRIGHTNESS_DIALOG_CONTRAST, "BrightnessDialog.Contrast");
        hash.put(GUIStr.GENERAL_ACCEPT, "General.Accept");
        hash.put(GUIStr.GENERAL_ERROR, "General.Error");
        hash.put(GUIStr.DIALOG_ERROR_NO_SELECTED_IMAGE, "DialogError.NoSelectedImage");
        hash.put(GUIStr.DIALOG_ERROR_GRAYSCALE_IMAGE, "DialogError.GrayscaleImage");
        hash.put(GUIStr.OPTION_OVERWRITE, "Option.Overwrite");
        hash.put(GUIStr.TOOLTIP_OPTION_OVERWRITE, "ToolTip.Option.Overwrite");
    }
    
    public static String get(GUIStr stringId){
        return hash.get(stringId);
    }
}

