package at.stefangeyer.challonge.service.implementation

import at.stefangeyer.challonge.async.Callback
import at.stefangeyer.challonge.exception.DataAccessException
import at.stefangeyer.challonge.model.Attachment
import at.stefangeyer.challonge.model.Match
import at.stefangeyer.challonge.model.query.AttachmentQuery
import at.stefangeyer.challonge.rest.AttachmentRestClient
import at.stefangeyer.challonge.service.AttachmentService

/**
 * Attachment Service Implementation
 *
 * @author Stefan Geyer
 * @version 2018-06-30
 */
class SimpleAttachmentService(private val restClient: AttachmentRestClient) : AttachmentService {

    override fun getAttachments(match: Match): List<Attachment> =
            this.restClient.getAttachments(match.tournamentId.toString(), match.id)

    override fun getAttachments(match: Match, onSuccess: Callback<List<Attachment>>, onFailure: Callback<DataAccessException>) {
        this.restClient.getAttachments(match.tournamentId.toString(), match.id, onSuccess, onFailure)
    }

    override fun getAttachment(match: Match, attachmentId: Long): Attachment =
            this.restClient.getAttachment(match.tournamentId.toString(), match.id, attachmentId)

    override fun getAttachment(match: Match, attachmentId: Long, onSuccess: Callback<Attachment>, onFailure: Callback<DataAccessException>) {
        this.restClient.getAttachment(match.tournamentId.toString(), match.id, attachmentId, onSuccess, onFailure)
    }

    override fun createAttachment(match: Match, data: AttachmentQuery): Attachment {
        validateAttachmentQuery(data)
        return this.restClient.createAttachment(match.tournamentId.toString(), match.id, data)
    }

    override fun createAttachment(match: Match, data: AttachmentQuery, onSuccess: Callback<Attachment>, onFailure: Callback<DataAccessException>) {
        validateAttachmentQuery(data)
        return this.restClient.createAttachment(match.tournamentId.toString(), match.id, data, onSuccess, onFailure)
    }

    override fun updateAttachment(match: Match, attachment: Attachment, data: AttachmentQuery): Attachment {
        validateAttachmentQuery(data)
        return this.restClient.updateAttachment(match.tournamentId.toString(), match.id, attachment.id, data)
    }

    override fun updateAttachment(match: Match, attachment: Attachment, data: AttachmentQuery, onSuccess: Callback<Attachment>, onFailure: Callback<DataAccessException>) {
        validateAttachmentQuery(data)
        return this.restClient.updateAttachment(match.tournamentId.toString(), match.id, attachment.id, data, onSuccess, onFailure)
    }

    override fun deleteAttachment(match: Match, attachment: Attachment): Attachment =
            this.restClient.deleteAttachment(match.tournamentId.toString(), match.id, attachment.id)

    override fun deleteAttachment(match: Match, attachment: Attachment, onSuccess: Callback<Attachment>, onFailure: Callback<DataAccessException>) {
        this.restClient.deleteAttachment(match.tournamentId.toString(), match.id, attachment.id, onSuccess, onFailure)
    }

    private fun validateAttachmentQuery(data: AttachmentQuery) {
        if (data.asset == null && data.url == null && data.description == null) {
            throw IllegalArgumentException("All data parameters are null. Provide at least one")
        }
    }
}