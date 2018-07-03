package maps;

import base.GameObjectManager;
import platform.Platform;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int height;
    private int width;

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", height=" + height +
                ", height=" + height +
                '}';
    }

    public void generate() {
        for(int titleY = 0; titleY < height; titleY ++){
            for(int titleX = 0; titleX < width; titleX ++){
                int mapData = data.get(titleY * width + titleX);
                if(mapData != 0){
                    Platform platform = new Platform();
                    platform.position.set(titleX * 32, titleY * 32);
                    GameObjectManager.instance.add(platform);
                }
            }
        }
    }
}
