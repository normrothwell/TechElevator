/**
 * 
 */
package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

public class TeamJdbcDAO implements TeamDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public TeamJdbcDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Team> retrieveTeams() {
		List<Team> output = new ArrayList<>();
		
		String sql = "select team_id, team_name, division_name, wins, losses, division_name from team JOIN division ON (team.division_id = division.division_id)";
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
		
		while (sqlRowSet.next()) {
			
			Team team = new Team();
			team.setTeamId(sqlRowSet.getInt("team_id"));
			team.setTeamName(sqlRowSet.getString("team_name"));
			team.setWins(sqlRowSet.getInt("wins"));
			team.setLosses(sqlRowSet.getInt("losses"));
			team.setDivision(sqlRowSet.getString("division_name"));
			
			output.add(team);
		}
		
		return output;
	}
}
