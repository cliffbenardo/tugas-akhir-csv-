package testmanusiacsv;
    
import java.nio.file.Path;
import java.util.List;

public interface CSV<T> {
	public void write(Path path, List<T> items);
	public List<T> read(Path path);
}
