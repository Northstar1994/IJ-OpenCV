package ijopencv.ij;

import ij.gui.PointRoi;
import ij.gui.Roi;
import java.lang.reflect.Type;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Point2f;
import org.scijava.Prioritized;
import org.scijava.Priority;
import org.scijava.convert.AbstractConverter;
import org.scijava.convert.Converter;
import org.scijava.log.LogService;
import org.scijava.plugin.Plugin;

@Plugin(type = Converter.class, priority = Priority.LOW_PRIORITY)
public class PointRoiPoint2fConverter extends AbstractConverter< PointRoi, Point2f> {

    @Override
    public int compareTo(Prioritized o) {
        return super.compareTo(o);
    }

    @Override
    public LogService log() {
        return super.log();
    }

    @Override
    public String getIdentifier() {
        return super.getIdentifier();
    }

    @Override
    public < T> T convert(Object o, Class< T> type) {
        PointRoi pr = (PointRoi) o;
        opencv_core.Point2f p = new opencv_core.Point2f(pr.getXCoordinates()[0], pr.getYCoordinates()[0]);
        return (T) p;

    }

    @Override
    public Class< opencv_core.Point2f> getOutputType() {
        return opencv_core.Point2f.class;
    }

    @Override
    public Class< PointRoi> getInputType() {
        return PointRoi.class;
    }

    @Override
    public boolean canConvert(Object src, Type dest) {
        if (!(src instanceof PointRoi)) {
            return false;
        }
        PointRoi pr = (PointRoi) src;
        if (pr.getType() != Roi.POINT) {
            return false;
        }
        return true;
    }

}
