def solution(idList, report, k):
    report = set(report)
    reportCount = {i : 0 for i in idList}
    mailCount = {i: 0 for i in idList}
    stoppedId = []
    answer = []

    for i in report:
        i, j = i.split(' ')
        reportCount[j] += 1

    for i in reportCount:
        if reportCount[i] >= k:
            stoppedId.append(i)

    for i in report:
        i, j = i.split(' ')
        if j in stoppedId:
            mailCount[i] += 1

    for i in mailCount:
        answer.append(mailCount[i])

    return answer
