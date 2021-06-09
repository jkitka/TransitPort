 package bdbt_proj_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
	
	public List<Port> listAsBasic() {

		String sql = "SELECT id_portu,nazwa,powierzchnia,data_zalozenia FROM PORTY";

		List<Port> listPort = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Port.class));
		
		System.out.println(listPort);
		return listPort;
	}

	/* Insert */
	public void save(Port port) {

		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Porty").usingColumns("ID_portu","Nazwa","Powierzchnia","Data_zalozenia","Osrodek_ratownictwa","ID_adresu");
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(port);
		insertActor.execute(param);
		
	}

	/* Read */
	public Port get(int id_portu) {
		
		Object[] args = {id_portu};
		String sql = "SELECT * FROM PORTY WHERE id_portu = " + args[0];
		Port port = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Port.class));
		
		
		return port;
	}

	/* Update */
	public void update(Port port) {

		String sql = "UPDATE PORTY SET  nazwa=:Nazwa, powierzchnia=:Powierzchnia, data_zalozenia=:Data_zalozenia, osrodek_ratownictwa=:Osrodek_ratownictwa, id_adresu=:ID_adresu WHERE id_portu=:ID_portu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(port);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		template.update(sql, param);
		
	}

	/* Delete */
	public void delete(int id) {
		String sql = "DELETE FROM PORTY WHERE id_portu = ?";
		jdbcTemplate.update(sql,id);
	}
}
