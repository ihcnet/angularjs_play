
<div class="page-header">
    <h1>Create Phone</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>

<form name="form" data-ng-submit="save(item)" class="form-horizontal">
    <g:render template="/ng-templates/phone/create"/>
    <div class="form-actions">
        <button type="submit" class="btn btn-primary" data-ng-disabled="form.$invalid"><i class="icon-ok"></i> Create
        </button>
    </div>
</form>