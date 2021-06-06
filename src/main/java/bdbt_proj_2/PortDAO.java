package bdbt_proj_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PortDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PortDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Port> list() {

		String sql = "SELECT * FROM PORTY";

		List<Port> listPort = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Port.class));
		
		System.out.println(listPort);
		return listPort;
	}

	/* Insert */
	public void save(Port port) {

	}

	/* Read */
	public Port get(int id) {
		return null;
	}

	/* Update */
	public void update(Port port) {

	}

	/* Delete */
	public void delete(int id) {

	}
}
