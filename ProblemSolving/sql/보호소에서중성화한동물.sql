SELECT a.animal_id,a.animal_type,a.name FROM animal_ins a
INNER JOIN animal_outs b ON a.animal_id = b.animal_id
WHERE a.sex_upon_intake LIKE '%Intact%'
AND (b.sex_upon_outcome LIKE '%Spayed%' OR b.sex_upon_outcome LIKE '%Neutered%')
ORDER BY animal_id