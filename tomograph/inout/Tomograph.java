package inout;

public class Tomograph {
    private int minX = 0;
    private int maxX = 0;
    private int minY = 0;
    private int maxY = 0;

    private int height = 0;
    private int width = 0;

    public Tomograph(Image image) {
        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();

        //coords: minX, maxX, minY, maxY
        int[] coords = {imageWidth, 0, imageHeight, 0};

        //localize on image
        for (int i = 0; i < imageHeight; i++) {
            for (int j = 0; j < imageWidth; j++) {
                if (image.getPixel(j, i) > 0) {
                    coords[0] = (j > coords[0] ? coords[0] : j);
                    coords[1] = (j < coords[1] ? coords[1] : j);
                    coords[2] = (i > coords[2] ? coords[2] : i);
                    coords[3] = (i < coords[3] ? coords[3] : i);
                }
            }
        }

        //save everything in private vars
        height = maxY - minY;
        width = maxX - minX;
        minX = coords[0];
        maxX = coords[1];
        minY = coords[2];
        maxY = coords[3];

        //copy object from image to Tomograph
    }

    public int[] getCoords() {
        int[] result = {minX, minY, maxX, maxY};
        return result;
    }
}
