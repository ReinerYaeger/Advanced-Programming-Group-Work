package Log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface LoggingService {

    public static final Logger log = LogManager.getLogger(LoggingService.class);
}
