package ua.com.jurimik.list;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CacheList<E> extends ArrayList<E> {

	private static final long serialVersionUID = 3188469789042759030L;

	private File file;

	public CacheList(File storage) {
		this.file = storage;
	}

	private void toFile() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		for (int i = 0; i < size(); i++) {
			oos.writeObject(get(i));
			oos.flush();
		}
		oos.close();
	}

	private List<E> fromFile() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		List<E> result = new ArrayList<>();
		while (ois.available() > 0) { // What I want do this?
			E e = (E) ois.readObject();
			result.add(e);
		}
		return result;

	}

	@Override
	public E set(int index, E element) {
		return super.set(index, element);
	}

	@Override
	public boolean add(E e) {
		boolean b = super.add(e);
		if (size() >= 10) {
			try {
				toFile();
			} catch (IOException ex) {
				// TODO anything
			}
		}
		return b;
	}

	@Override
	public boolean contains(Object o) {
		boolean b = super.contains(o);
		if (!b) {
			List<E> archive = null;
			try {
				archive = fromFile();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
			}
			b = archive.contains(o);
		}
		return b;
	}

	@Override
	public E remove(int index) {
		E e = super.remove(index);
		if (e == null) {
			List<E> archive = null;
			try {
				archive = fromFile();
			} catch (ClassNotFoundException | IOException ex) {
				// TODO Auto-generated catch block
			}
			e = archive.remove(index);
		}
		return e;
	}

	@Override
	public boolean remove(Object o) {
		boolean b = super.remove(o);
		if (!b) {
			List<E> archive = null;
			try {
				archive = fromFile();
			} catch (ClassNotFoundException | IOException ex) {
				// TODO Auto-generated catch block
			}
			b = archive.remove(o);
		}
		return b;
	}
	
	

}
