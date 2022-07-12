package com.learning.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Package: com.learning.springframework.core.io
 * @Description: Resource
 * @Author: Sammy
 * @Date: 2022/7/12 10:33
 */

public interface Resource {

	InputStream getInputStream() throws IOException;

}
