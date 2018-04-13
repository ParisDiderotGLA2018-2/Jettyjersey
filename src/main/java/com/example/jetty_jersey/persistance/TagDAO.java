package persistance;

import com.example.jetty_jersey.ws.Tag.TagClass;

interface TagDAO {
	TagClass getTag();
	void addTag(TagClass instance);
	void editTag(int id, TagClass instance);
	void deleteTag(TagClass instance);
}