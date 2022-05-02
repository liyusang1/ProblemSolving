SELECT a.animal_id,a.name FROM animal_outs a
JOIN animal_ins b ON a.animal_id = b.animal_id
ORDER BY a.datetime-b.datetime DESC LIMIT 2