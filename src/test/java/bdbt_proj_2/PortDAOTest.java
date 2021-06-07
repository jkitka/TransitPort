package bdbt_proj_2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class PortDAOTest {

	private PortDAO dao;

	@BeforeEach
	void setUp() throws Exception {

		DriverManagerDataSource datasource = new DriverManagerDataSource();

		datasource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
		datasource.setUsername("jmajkows");
		datasource.setPassword("jmajkows");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		/* Import JdbcTemplate */
		dao = new PortDAO(new JdbcTemplate(datasource));

	}

	@Test
	void testList() {
		List<Port> listPort = dao.list();
		assertTrue(!listPort.isEmpty());

	}

	@Test
	void testSave() {
		Port port = new Port(6, "Nowy port", 4040, "2020-05-25", "WOPRRR", 3);
		dao.save(port);
	}

	@Test
	void testGet() {
		
		int id_portu = 1;
		Port port = dao.get(id_portu);
		assertNotNull(port);
		
	}

	@Test
	void testUpdate() {
	
		Port port = new Port();
		port.setID_adresu(22);
		port.setNazwa("Port Szczecinn 3");
		port.setPowierzchnia(4334);
		port.setData_zalozenia("2019-11-11");
		port.setOsrodek_ratownictwa("WOPR Szczecin");
		port.setID_adresu(3);
		
		dao.update(port);
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
