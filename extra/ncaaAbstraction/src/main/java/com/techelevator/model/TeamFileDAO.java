package com.techelevator.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class TeamFileDAO implements TeamDAO {

	@Override
	public List<Team> retrieveTeams() {
		
		List<Team> teamsList = new ArrayList<>();
		
		Resource fileResource = new ClassPathResource("ncaa.csv");
		try (Scanner inputScanner = new Scanner(fileResource.getFile())){

			while (inputScanner.hasNextLine()) {
				
				String lineOfData = inputScanner.nextLine();
				System.out.println(lineOfData);
				String [] lineOfDataArr = lineOfData.split(",");
				
				Team team = new Team();
				team.setTeamId(Integer.parseInt(lineOfDataArr[0]));
				team.setTeamName(lineOfDataArr[1]);		
				team.setDivision(lineOfDataArr[2]);
				team.setWins(Integer.parseInt(lineOfDataArr[3]));
				team.setLosses(Integer.parseInt(lineOfDataArr[4]));
				
				teamsList.add(team);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();

		}
		
		return teamsList;
	}
}
