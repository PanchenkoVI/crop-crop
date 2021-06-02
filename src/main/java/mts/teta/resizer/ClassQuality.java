package mts.teta.resizer;

import java.io.File;
import java.io.IOException;
import net.coobird.thumbnailator.Thumbnails;
import mts.teta.resizer.imageprocessor.BadAttributesException;

public class ClassQuality {
    private double _quality;

    ClassQuality(double quality, String[] arg, File inputFile, File outputFile)
            throws IOException, BadAttributesException {
        if(inputFile == null || quality > 100)
            throw new BadAttributesException("Please check params!");
        _quality = quality / 100;
        Thumbnails.of(inputFile).outputQuality(_quality).toFile(outputFile);
    }
}