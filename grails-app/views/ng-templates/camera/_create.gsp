
<g:set var="CameraSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
    
    <div class="control-group" data-ng-class="{error: errors.${CameraSubPrefix}cameraType}">
        <label class="control-label" for="${CameraSubPrefix}cameraType">Camera Type</label>
        <div class="controls">
            <input type="text" id="cameraType" name="cameraType" data-ng-model="item.${CameraSubPrefix}cameraType">

            <span class="help-inline" data-ng-show="errors.${CameraSubPrefix}cameraType">{{errors.${CameraSubPrefix}cameraType}}</span>
        </div>
    </div>

    <g:render template="/ng-templates/feature/hasManyList" model="[subPrefix: CameraSubPrefix + 'features']" /><g:render template="/ng-templates/feature/hasManyCreate" model="[subPrefix: CameraSubPrefix + 'features']" />


