select a.Name from Employee a inner join Employee b on a.ManagerId = b.Id where a.Salary > b.Salary;