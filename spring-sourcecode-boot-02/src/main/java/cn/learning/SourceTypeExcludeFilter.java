package cn.learning;

import cn.learning.service.UserService;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Package: cn.learning
 * @Description: SourceTypeExcludeFilter
 * @Author: Sammy
 * @Date: 2022/7/31 20:32
 */
@Component
public class SourceTypeExcludeFilter extends TypeExcludeFilter {

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		return metadataReader.getClassMetadata().getClassName().equals(UserService.class.getName());
	}
}
