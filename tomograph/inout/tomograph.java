package inout;

/**
 * Created by Piotr on 2017-03-11.
 */
public class tomograph {
    private int obj_min_x = 0;
    private int obj_max_x = 0;
    private int obj_min_y = 0;
    private int obj_max_y = 0;
    private int obj_h = 0;
    private int obj_w = 0;

    public tomograph(img Image) {
        int img_h = Image.getHeight();
        int img_w = Image.getWidth();
        //coords: minX, maxX, minY, maxY
        int[] coords = {img_w, 0, img_h, 0};
        //localize object on img
        for (int i = 0; i < img_h; i++) {
            for (int j = 0; j < img_w; j++) {
                if (Image.getPixel(j, i) > 0) {
                    coords[0] = (j > coords[0] ? coords[0] : j);
                    coords[1] = (j < coords[1] ? coords[1] : j);
                    coords[2] = (i > coords[2] ? coords[2] : i);
                    coords[3] = (i < coords[3] ? coords[3] : i);
                }
            }
        }
        //save everything in private vars
        obj_h = obj_max_y - obj_min_y;
        obj_w = obj_max_x - obj_min_x;
        obj_min_x = coords[0];
        obj_max_x = coords[1];
        obj_min_y = coords[2];
        obj_max_y = coords[3];
        //copy object from image to tomograph
    }

    public int[] getCoords() {
        int[] result = {obj_min_x, obj_min_y, obj_max_x, obj_max_y};
        return result;
    }
}
