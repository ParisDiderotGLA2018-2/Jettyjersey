package persistance;

import com.example.jetty_jersey.ws.ListImage.ListImageClass;

public interface ListImageDAO {
	ListImageClass getListImage();
	void addListImage(ListImageClass instance);
	void editListImage(int id, ListImageClass instance);
	void deleteListImage(ListImageClass instance);
}
