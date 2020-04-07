package sam.onetime.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Resource
 * 
 * Contains the details of a single resource.
 *
 *
 * Nr.   Name       Date         Release/Description
 *---------------------------------------------------
 * 02
 * 01   Sarat     07 04 2020      New Class
 *
 * @author Sarat
 *
 *
 */

@Getter
@Setter
@NoArgsConstructor
public class Resource {

	private String name;
	private float meeting;
	private float testExcecution;
	private float envSetup;
	private float infrastructureIssue;
	private float pairProgramming;
	private float documentation;
//	private List<Work> workList;
	private float review;
	private float others;
	private float checkin;
	private float allHands;
	private float training;

}
