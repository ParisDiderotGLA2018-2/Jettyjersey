package persistance;

import com.example.jetty_jersey.ws.Image.ImageClass;

interface ImageDAO {
	ImageClass getImage();
	void addImage(ImageClass instance);
	void editImage(int id, ImageClass instance);
	void deleteImage(ImageClass instance);
}
