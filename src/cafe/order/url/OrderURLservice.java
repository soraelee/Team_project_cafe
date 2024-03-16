package cafe.order.url;

import java.nio.file.Paths;

public interface OrderURLservice {
public String fxPath = "file:/" + (Paths.get("").toAbsolutePath().toString()) + "/bin/";
}

