<%--
  Created by IntelliJ IDEA.
  User: lgaleron
  Date: 10/10/2015
  Time: 18:33
--%>

<div class="row" id="new_message">
    <g:form accept-charset="UTF-8" url="[action:'sharedPost',controller:'post']">
        <div class="col-md-10 col-md-offset-1 well">
            <textarea class="form-control" name="message"
                      placeholder="Type in your message"
                      rows="5" required></textarea>

            <div style="margin-top:10px">
                <h6 class="pull-right "><span
                        class="nb_carac_remaining">320</span> characters remaining
                </h6>

                <button class="btn btn-info"
                        type="submit">Post New Message</button>
            </div>
            <br /> ${error}
        </div>
    </g:form>
</div>