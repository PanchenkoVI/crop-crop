package mts.teta.resizer;

import java.io.IOException;
import mts.teta.resizer.imageprocessor.BadAttributesException;

public class ImageProcessor extends ResizerApp {

    void processImage(ResizerApp rap) throws BadAttributesException, IOException {
        if (rap.reO == null && rap.qltO <= 0 && rap.cpO == null && rap.brO <= 0 && rap.ftO == null)
            throw new BadAttributesException("Please check params!");
        if (rap.reO != null) {
            ClassResize resize = new ClassResize(rap.reO, rap.qltO, rap.inputFile, rap.outputFile, rap.arg);
        }
        else if (rap.qltO > 0) {
            ClassQuality quality = new ClassQuality(rap.qltO, rap.arg, rap.inputFile, rap.outputFile);
        }
        else if (rap.cpO != null) {
            ClassCrop crop = new ClassCrop(rap.cpO, rap.arg[1], rap.inputFile, rap.outputFile);
        }
        else if (rap.brO > 0) {
            ClassBlur blur = new ClassBlur(rap.brO, rap.inputFile, rap.outputFile, rap.arg[1]);
        }
        else if (rap.ftO != null) {
            ClassFormat format = new ClassFormat(rap.arg, rap.ftO);
        }
    }
}