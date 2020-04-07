
package sam.onetime.config.in;

import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import sam.onetime.model.Resource;

/**
 * ResourceRowMapper
 *
 *This class demonstrates how we can implement a row mapper that maps
 * a row found from an Excel document into a {@code Resource} object. If
 * the Excel document has no header, we have to use this method for transforming
 * the input data into {@code Resource} objects.
 * 
 *
 * Nr.   Name       Date         Release/Description
 *---------------------------------------------------
 * 02
 * 01   Sarat     08 04 2020      New Class
 *
 * @author Sarat
 *
 *
 */
public class ResourceRowMapper implements RowMapper<Resource> {

	@Override
	public Resource mapRow(final RowSet rs) throws Exception {
		Resource resource = new Resource();

		// TODO map the columns
		return resource;
	}

}
