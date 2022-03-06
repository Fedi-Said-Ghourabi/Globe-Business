package tn.globebusiness.spring.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.globebusiness.spring.Entities.Complaint;
import tn.globebusiness.spring.Entities.Employee;
import tn.globebusiness.spring.Entities.Travel;
import tn.globebusiness.spring.Repositories.ComplaintRepository;
import tn.globebusiness.spring.Repositories.EmployeeRepository;
import tn.globebusiness.spring.Repositories.TravelRepository;

@Service
public class ComplaintService implements IComplaintService {

	@Autowired
	ComplaintRepository cr;
	@Autowired
	EmployeeRepository er;
	@Autowired
	TravelRepository tr;
	@Override
	public Complaint addComplaint (Complaint complaint,Long idEmployee,Long idTravel){
		complaint.setEmployee(er.findById(idEmployee).get());
		complaint.setTravel(tr.findById(idTravel).get());
		complaint.setFeedbackDate(new Date());
		return cr.save(complaint);
	}
	
	@Override
	public void deleteComplaint(Long idC){
		cr.deleteById(idC);
	}
	
	@Override
	public Optional<Complaint> displayComplaint(Long idC) {
            return cr.findById(idC);
    }
	@Override
	public List<Complaint> displayAllUserComplaints(Long idEmployee){
		Employee employee=er.findById(idEmployee).get();
		return (List<Complaint>) cr.displayAllUserComplaints(employee);
	}

	public List<Complaint> findByTitle (String Title){
		return (List<Complaint>) cr.findByTitle(Title);	
	}

	@Override
	public List<Complaint> displayAllTravelComplaints(Long idTravel) {
		Travel travel=tr.findById(idTravel).get();
		List<Complaint> complaints=(List<Complaint>) cr.displayAllTravelComplaints(travel);
		if(!complaints.isEmpty()){
			complaints.sort((p1,p2)->-(p1.getFeedbackDate().compareTo(p2.getFeedbackDate())));
		}
		return complaints;
	}
	

}