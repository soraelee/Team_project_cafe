package stockURL;

import java.nio.file.Paths;

public interface URL {
	public interface URLService {
		public String stkpath ="file:/" +(Paths.get("").toAbsolutePath().toString() ) + "/bin/";


	}

}
