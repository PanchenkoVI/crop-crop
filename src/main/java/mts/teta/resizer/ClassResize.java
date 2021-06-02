package mts.teta.resizer;

import java.io.File;
import java.io.IOException;
import net.coobird.thumbnailator.Thumbnails;
import mts.teta.resizer.imageprocessor.BadAttributesException;

public class ClassResize {
    private int ind = 0;

    ClassResize(Integer [] resize, double quality, File inputFile, File outputFile, String[] arg)
                throws BadAttributesException, IOException {
        if(inputFile == null || resize.length != 2 )
            ind = -1;
        else if (resize[0] < 0 || resize[1] < 0)
            ind = -1;
        else if (resize[0] > 2147483647 || resize[1] > 2147483647)
            ind = -1;
        if (ind == -1)
            throw new BadAttributesException("Please check params!");
        quality /= 100;
        if(resize != null && quality >= 0) {
            Thumbnails.of(inputFile)
                    .size(resize[0], resize[1])
                    .keepAspectRatio(false)
                    .outputQuality(quality)
                    .toFile(outputFile);
        }
        else if(resize != null && quality < 0) {
            Thumbnails.of(inputFile)
                    .size(resize[0], resize[1])
                    .keepAspectRatio(false)
                    .toFile(outputFile);
        }
    }
}